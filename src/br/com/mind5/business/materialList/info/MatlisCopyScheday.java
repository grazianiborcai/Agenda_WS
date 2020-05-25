package br.com.mind5.business.materialList.info;


import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatlisCopyScheday extends InfoCopierTemplate<MatlisInfo, SchedayInfo> {
	
	public MatlisCopyScheday() {
		super();
	}
	
	
	
	@Override protected MatlisInfo makeCopyHook(SchedayInfo source) {
		MatlisInfo result = new MatlisInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;

		return result;
	}
}
