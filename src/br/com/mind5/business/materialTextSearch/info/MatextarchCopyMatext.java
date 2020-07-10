package br.com.mind5.business.materialTextSearch.info;


import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatextarchCopyMatext extends InfoCopierTemplate<MatextarchInfo, MatextInfo> {
	
	public MatextarchCopyMatext() {
		super();
	}
	
	
	
	@Override protected MatextarchInfo makeCopyHook(MatextInfo source) {
		MatextarchInfo result = new MatextarchInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.username = source.username;
		result.codLanguage = null;
		
		return result;
	}
}
