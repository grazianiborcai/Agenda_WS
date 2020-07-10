package br.com.mind5.business.materialSnapshot.info;


import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatsnapCopyOrdemrap extends InfoCopierTemplate<MatsnapInfo, OrdemrapInfo> {
	
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
