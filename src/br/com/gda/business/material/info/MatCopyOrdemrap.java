package br.com.gda.business.material.info;


import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class MatCopyOrdemrap extends InfoCopierTemplate<MatInfo, OrdemrapInfo>{
	
	public MatCopyOrdemrap() {
		super();
	}
	
	
	
	@Override protected MatInfo makeCopyHook(OrdemrapInfo source) {
		MatInfo result = new MatInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
