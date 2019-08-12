package br.com.gda.business.material.info;


import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.info.InfoCopierTemplate;

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
