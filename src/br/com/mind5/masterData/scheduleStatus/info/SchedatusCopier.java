package br.com.mind5.masterData.scheduleStatus.info;

import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class SchedatusCopier {
	public static List<SchedatusInfo> copyFromScheday(SchedayInfo source) {
		InfoCopierOneToMany<SchedatusInfo, SchedayInfo> copier = new SchedatusCopyScheday();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedatusInfo> copyFromScheday(List<SchedayInfo> sources) {
		InfoCopierOneToMany<SchedatusInfo, SchedayInfo> copier = new SchedatusCopyScheday();
		return copier.makeCopy(sources);
	}	
}
