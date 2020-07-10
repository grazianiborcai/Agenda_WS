package br.com.mind5.business.materialTextSearch.info;


import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatextarchCopyMatextsnap extends InfoCopierTemplate<MatextarchInfo, MatextsnapInfo> {
	
	public MatextarchCopyMatextsnap() {
		super();
	}
	
	
	
	@Override protected MatextarchInfo makeCopyHook(MatextsnapInfo source) {
		MatextarchInfo result = new MatextarchInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.username = source.username;
		result.codLanguage = null;
		
		return result;
	}
}
