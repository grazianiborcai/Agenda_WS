package br.com.mind5.business.materialList.info;


import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatlisCopyOrderem extends InfoCopierTemplate<MatlisInfo, OrderemInfo>{
	
	public MatlisCopyOrderem() {
		super();
	}
	
	
	
	@Override protected MatlisInfo makeCopyHook(OrderemInfo source) {
		MatlisInfo result = new MatlisInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
