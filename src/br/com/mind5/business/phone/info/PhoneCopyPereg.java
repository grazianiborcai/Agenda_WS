package br.com.mind5.business.phone.info;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhoneCopyPereg extends InfoCopierTemplate<PhoneInfo, PeregInfo> {
	
	public PhoneCopyPereg() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(PeregInfo source) {
		return source.phoneData;
	}
}
