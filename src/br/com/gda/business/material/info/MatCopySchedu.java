package br.com.gda.business.material.info;


import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.info.InfoCopierTemplate;

final class MatCopySchedu extends InfoCopierTemplate<MatInfo, ScheduInfo>{
	
	public MatCopySchedu() {
		super();
	}
	
	
	
	@Override protected MatInfo makeCopyHook(ScheduInfo source) {
		MatInfo result = new MatInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
