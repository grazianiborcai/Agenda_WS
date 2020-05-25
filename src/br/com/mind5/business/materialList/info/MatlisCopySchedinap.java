package br.com.mind5.business.materialList.info;


import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatlisCopySchedinap extends InfoCopierTemplate<MatlisInfo, SchedinapInfo> {
	
	public MatlisCopySchedinap() {
		super();
	}
	
	
	
	@Override protected MatlisInfo makeCopyHook(SchedinapInfo source) {
		MatlisInfo result = new MatlisInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
