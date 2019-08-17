package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.info.InfoCopier;

public final class MatsnapCopier {
	public static MatsnapInfo copyFromSchedinap(SchedinapInfo source) {
		InfoCopier<MatsnapInfo, SchedinapInfo> copier = new MatsnapCopySchedinap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatsnapInfo> copyFromSchedinap(List<SchedinapInfo> sources) {
		InfoCopier<MatsnapInfo, SchedinapInfo> copier = new MatsnapCopySchedinap();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static MatsnapInfo copyFromOrderem(OrderemInfo source) {
		InfoCopier<MatsnapInfo, OrderemInfo> copier = new MatsnapCopyOrderem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatsnapInfo> copyFromOrderem(List<OrderemInfo> sources) {
		InfoCopier<MatsnapInfo, OrderemInfo> copier = new MatsnapCopyOrderem();
		return copier.makeCopy(sources);
	}	
}
