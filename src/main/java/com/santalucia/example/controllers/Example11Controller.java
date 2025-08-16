package com.santalucia.example.controllers;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.santalucia.example.core.domain.AccuinsfluDomain;
import com.santalucia.example.core.domain.ChatPrompt;
import com.santalucia.example.core.mappers.AccuinsfluMapper;
import com.santalucia.example.infrastructure.dto.AccuinsfluDto;
import com.santalucia.example.infrastructure.model.Welcome6;
import com.santalucia.example.infrastructure.repository.primary.AccuinsfluRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("/example11")
@Slf4j
public class Example11Controller {

    private final NamedParameterJdbcOperations jdbcTemplate; 
    private final AccuinsfluRepository accuinsRepository;
    private final AccuinsfluMapper accuinsfluMapper;
    private final ChatClient chatClient;
    
    @Value("${ai.user}") String userUser;
	
	public Example11Controller(@Qualifier("primaryJdbcTemplate") NamedParameterJdbcOperations jdbcTemplate,
			AccuinsfluRepository accuinsRepository, AccuinsfluMapper accuinsfluMapper, 
			ChatClient.Builder chatBuilder) {
		this.jdbcTemplate = jdbcTemplate;
		this.accuinsRepository = accuinsRepository;
		this.accuinsfluMapper = accuinsfluMapper;
		this.chatClient = chatBuilder.build();
	}
	
	@GetMapping("/indicators/{indicadorId}")
	@SuppressWarnings("NullAway")
	public WebAsyncTask<ResponseEntity<AccuinsfluDto>> getIndicadorById(
			@PathVariable("indicadorId") String indicadorId, 
			@RequestParam(defaultValue = "1")  Optional<Long> page, 
			@RequestHeader HttpHeaders headers,
			@RequestParam(required = false) ZonedDateTime startDate, UriComponentsBuilder uriBuilder) {
		
		log.info("Main thread: {}", Thread.currentThread()); 
		Callable<ResponseEntity<AccuinsfluDto>> callable =  () ->{
			log.info("Callable thread: {}", Thread.currentThread()); 
			
			
			List<AccuinsfluDomain> result = accuinsRepository.findByNidinflu(indicadorId);
			
			log.info("Result:  {}", result);
			
			var uri = uriBuilder.path("/indicators/{indicadorId}").buildAndExpand(indicadorId).toUri();

			log.info("UriComponentes: {}", uri);
			
			return ResponseEntity.of(!result.isEmpty() ? 
					Optional.of(accuinsfluMapper.convert(result.get(0))) : Optional.empty());
		};
		
		return new WebAsyncTask<>(10000l, "amsTaskExecutor", callable);
		
	}
	
	@GetMapping("/indicators")
	Page<AccuinsfluDomain> findAllIndicators(Pageable pageable){
		

		return accuinsRepository.findAll(pageable);
	}
	
	@GetMapping("/random-names")
	public ResponseEntity<Welcome6> getRandomName(){
		RestClient restClient = RestClient.builder().baseUrl("https://randomuser.me/api/").build();
		
		return restClient.method(HttpMethod.GET).accept(MediaType.APPLICATION_JSON).
			retrieve().toEntity(Welcome6.class);
		

	}
	
	@PostMapping("uploads")
	public ResponseEntity<Void> uploadFile(@RequestParam MultipartFile file, 
			@RequestParam Optional<MultipartFile> file2) throws IOException {
		log.info("File upload {} with size {} and mime type {} and path normalized {}", file.getOriginalFilename(), file.getResource().getContentAsByteArray().length,
				file.getContentType(), StringUtils.cleanPath(file.getOriginalFilename()));
		

		if (file2.isPresent()) {
			log.info("File upload2 {} with size {}", 
					file2.get().getOriginalFilename(), file2.get().getResource().getContentAsByteArray().length);
		}
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping("chat")
	public String chat(@Valid @RequestBody ChatPrompt chatPrompt) {

		Prompt prompt = new Prompt(chatPrompt.query(), OpenAiChatOptions.builder().
				temperature(chatPrompt.temperature()).build());
		
		
		return chatClient.prompt(prompt).
				user(userUser).call().content();
	}
}
