package br.com.mind5.business.material.info;


import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatCopyCartem extends InfoCopierTemplate<MatInfo, CartemInfo>{
	
	public MatCopyCartem() {
		super();
	}
	
	
	
	@Override protected MatInfo makeCopyHook(CartemInfo source) {
		MatInfo result = new MatInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
