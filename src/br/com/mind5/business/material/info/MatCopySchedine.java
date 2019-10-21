package br.com.mind5.business.material.info;


import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatCopySchedine extends InfoCopierTemplate<MatInfo, SchedineInfo>{
	
	public MatCopySchedine() {
		super();
	}
	
	
	
	@Override protected MatInfo makeCopyHook(SchedineInfo source) {
		MatInfo result = new MatInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
