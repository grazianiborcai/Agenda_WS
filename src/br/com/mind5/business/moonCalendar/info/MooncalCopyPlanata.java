package br.com.mind5.business.moonCalendar.info;


import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MooncalCopyPlanata extends InfoCopierTemplate<MooncalInfo, PlanataInfo> {
	
	public MooncalCopyPlanata() {
		super();
	}
	
	
	
	@Override protected MooncalInfo makeCopyHook(PlanataInfo source) {
		MooncalInfo result = new MooncalInfo();
		
		result.moonDate = source.date;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
