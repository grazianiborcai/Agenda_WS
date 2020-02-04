package br.com.mind5.security.username.info;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyCarterco extends InfoCopierTemplate<UsernameInfo, CartercoInfo>{
	
	public UsernameCopyCarterco() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(CartercoInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
