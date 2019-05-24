package br.com.gda.business.material.info;


import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.info.InfoCopierTemplate;

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
