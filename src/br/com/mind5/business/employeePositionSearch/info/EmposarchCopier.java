package br.com.mind5.business.employeePositionSearch.info;

import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.info.InfoCopier;

public final class EmposarchCopier {	
	public static EmposarchInfo copyFromEmpos(EmposInfo source) {
		InfoCopier<EmposarchInfo, EmposInfo> copier = new EmposarchCopyEmpos();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmposarchInfo> copyFromEmpos(List<EmposInfo> sources) {
		InfoCopier<EmposarchInfo, EmposInfo> copier = new EmposarchCopyEmpos();
		return copier.makeCopy(sources);
	}
}
