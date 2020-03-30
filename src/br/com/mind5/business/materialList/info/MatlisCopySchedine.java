package br.com.mind5.business.materialList.info;


import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatlisCopySchedine extends InfoCopierTemplate<MatlisInfo, SchedineInfo>{
	
	public MatlisCopySchedine() {
		super();
	}
	
	
	
	@Override protected MatlisInfo makeCopyHook(SchedineInfo source) {
		MatlisInfo result = new MatlisInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
