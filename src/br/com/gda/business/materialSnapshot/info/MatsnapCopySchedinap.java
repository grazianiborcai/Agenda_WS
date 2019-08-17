package br.com.gda.business.materialSnapshot.info;


import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class MatsnapCopySchedinap extends InfoCopierTemplate<MatsnapInfo, SchedinapInfo>{
	
	public MatsnapCopySchedinap() {
		super();
	}
	
	
	
	@Override protected MatsnapInfo makeCopyHook(SchedinapInfo source) {
		MatsnapInfo result = new MatsnapInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codSnapshot = source.codMatSnapshot;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
