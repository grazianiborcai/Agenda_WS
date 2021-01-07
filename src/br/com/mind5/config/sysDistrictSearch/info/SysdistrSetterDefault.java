package br.com.mind5.config.sysDistrictSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SysdistrSetterDefault extends InfoSetterTemplate<SysdistrInfo> {
	
	@Override protected SysdistrInfo setAttrHook(SysdistrInfo recordInfo) {
		recordInfo.districtSearchDefault = "RIOJANEIROCENTRO";
		return recordInfo;
	}
}
