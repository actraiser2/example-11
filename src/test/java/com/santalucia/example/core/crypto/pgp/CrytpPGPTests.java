package com.santalucia.example.core.crypto.pgp;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.bouncycastle.openpgp.PGPException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import com.santalucia.arq.ams.utils.crypto.pgp.utils.PgpDecrypt;
import com.santalucia.arq.ams.utils.crypto.pgp.utils.PgpEncrypt;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CrytpPGPTests {

	@Value("classpath:keys/public_key_medallia.asc") Resource publicKey;
	
	@Value("classpath:keys/private_key.asc") Resource privateKey;
	
	@Value("classpath:mappings/hello-stub.json") Resource plainTextFile;
	
	@Value("classpath:files/fichero_texto_claro.txt.pgp") Resource encryptedTextFile;
	
	@Test
	void testEncryptPgp() throws PGPException, IOException {
		var encryptedFile = PgpEncrypt.encrypt(plainTextFile.getContentAsByteArray(), publicKey.getContentAsByteArray());
		
		Assertions.assertThat(new String(encryptedFile)).containsSubsequence("-----BEGIN PGP MESSAGE-----");
		log.info(new String(encryptedFile));
	}
	
	@Test
	void testDecryptPgp() throws PGPException, IOException {
		
		String pass = "Des_entorno2022$";
		
		var plainTextFile = PgpDecrypt.decrypt(encryptedTextFile.getContentAsByteArray(), 
				privateKey.getContentAsByteArray(), pass);
		
		log.info("Decrypt ------------->" + new String(plainTextFile));
		Assertions.assertThat(new String(plainTextFile)).hasSizeGreaterThan(0);
	
	}
}
