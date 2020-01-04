package br.com.mind5.business.customerList.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;

public final class CuslisCopier {
	public static CuslisInfo copyFromCart(CartInfo source) {
		InfoCopier<CuslisInfo, CartInfo> copier = new CuslisCopyCart();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CuslisInfo> copyFromCart(List<CartInfo> sources) {
		InfoCopier<CuslisInfo, CartInfo> copier = new CuslisCopyCart();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<CuslisInfo> copyFromSchedeek(SchedeekInfo source) {
		InfoCopierOneToMany<CuslisInfo, SchedeekInfo> copier = new CuslisCopySchedeek();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CuslisInfo> copyFromSchedeek(List<SchedeekInfo> sources) {
		InfoCopierOneToMany<CuslisInfo, SchedeekInfo> copier = new CuslisCopySchedeek();
		return copier.makeCopy(sources);
	}
	
	
	
	public static CuslisInfo copyFromAddresnap(AddresnapInfo source) {
		InfoCopier<CuslisInfo, AddresnapInfo> copier = new CuslisCopyAddresnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CuslisInfo> copyFromAddresnap(List<AddresnapInfo> sources) {
		InfoCopier<CuslisInfo, AddresnapInfo> copier = new CuslisCopyAddresnap();
		return copier.makeCopy(sources);
	}
	
	
	
	public static CuslisInfo copyFromPhonap(PhonapInfo source) {
		InfoCopier<CuslisInfo, PhonapInfo> copier = new CuslisCopyPhonap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CuslisInfo> copyFromPhonap(List<PhonapInfo> sources) {
		InfoCopier<CuslisInfo, PhonapInfo> copier = new CuslisCopyPhonap();
		return copier.makeCopy(sources);
	}
}
