package br.com.mind5.business.personSearch.info;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PerarchCopyCusarch extends InfoCopierTemplate<PerarchInfo, CusarchInfo> {
	
	public PerarchCopyCusarch() {
		super();
	}
	
	
	
	@Override protected PerarchInfo makeCopyHook(CusarchInfo source) {
		PerarchInfo result = PerarchInfo.copyFrom(source.persolisData);
		return result;
	}
}
