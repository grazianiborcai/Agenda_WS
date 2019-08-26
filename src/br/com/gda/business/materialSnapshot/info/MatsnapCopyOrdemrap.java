package br.com.gda.business.materialSnapshot.info;


import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class MatsnapCopyOrdemrap extends InfoCopierTemplate<MatsnapInfo, OrdemrapInfo>{
	
	public MatsnapCopyOrdemrap() {
		super();
	}
	
	
	
	@Override protected MatsnapInfo makeCopyHook(OrdemrapInfo source) {
		MatsnapInfo result = new MatsnapInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codSnapshot = source.codMatSnapshot;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
