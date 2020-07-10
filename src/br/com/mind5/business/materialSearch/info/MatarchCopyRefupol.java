package br.com.mind5.business.materialSearch.info;


import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatarchCopyRefupol extends InfoCopierTemplate<MatarchInfo, RefupolInfo> {
	
	public MatarchCopyRefupol() {
		super();
	}
	
	
	
	@Override protected MatarchInfo makeCopyHook(RefupolInfo source) {
		MatarchInfo result = new MatarchInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
