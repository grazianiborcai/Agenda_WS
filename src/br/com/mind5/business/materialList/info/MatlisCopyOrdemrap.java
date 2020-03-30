package br.com.mind5.business.materialList.info;


import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatlisCopyOrdemrap extends InfoCopierTemplate<MatlisInfo, OrdemrapInfo>{
	
	public MatlisCopyOrdemrap() {
		super();
	}
	
	
	
	@Override protected MatlisInfo makeCopyHook(OrdemrapInfo source) {
		MatlisInfo result = new MatlisInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
