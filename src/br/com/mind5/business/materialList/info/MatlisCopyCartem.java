package br.com.mind5.business.materialList.info;


import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatlisCopyCartem extends InfoCopierTemplate<MatlisInfo, CartemInfo>{
	
	public MatlisCopyCartem() {
		super();
	}
	
	
	
	@Override protected MatlisInfo makeCopyHook(CartemInfo source) {
		MatlisInfo result = new MatlisInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
