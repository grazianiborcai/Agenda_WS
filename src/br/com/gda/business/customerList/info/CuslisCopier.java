package br.com.gda.business.customerList.info;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.info.InfoCopierOneToMany;

public final class CuslisCopier {
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
