package com.santalucia.example.infrastructure.mybatisnformix.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.santalucia.example.core.domain.AgenciaDomain;

@Mapper
public interface AgenciaDaoMapper {

	@Select("select g.dprov, h.dpoblaci, c.dagencia,"
			+ "              case f.dtvia when null then ' ' else f.dtvia end as dtvia," + "              b.ddomici"
			+ "      FROM domicagenc a, domicilios b, agencias c, centrasiis d,"
			+ "                      outer tvia f, provincias g, nuclepobla h,"
			+ "                      outer medcomunic mc, medcomagen ma"
			+ "      where a.ctdomici = 'PR' and b.nidendom = a.nidendom"
			+ "            and c.centidad = a.centidad and c.cagencia = a.cagencia and c.ffivaldt = '9999-12-31'"
			+ "            and d.cagencia = c.cagencia and d.cofagenc = 0"
			+ "            and not exists (select * from cacetrafec e"
			+ "                            where e.ccentrab = d.ccentrab and e.xcacetra = 'W'"
			+ "                                  and e.ffivaldt = '9999-12-31')" + "            and f.ctvia = b.ctvia"
			+ "            and g.cprov = b.cprov"
			+ "            and h.cprov = b.cprov and h.clocali = b.clocali and h.centcol = 0 and h.centsin = 0"
			+ "            and ma.cagencia = c.cagencia"
			+ "            and mc.nidmecom = ma.nidmecom and mc.xtmedcom = 'C' and mc.norden > 0"
			+ "      order by b.cprov, b.clocali, a.cagencia ASC;")
	List<AgenciaDomain> getAgencias();

}
