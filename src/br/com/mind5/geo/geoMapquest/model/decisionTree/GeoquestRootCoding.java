package br.com.mind5.geo.geoMapquest.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.geo.geoMapquest.info.GeoquestInfo;
import br.com.mind5.geo.geoMapquest.model.action.GeoquestVisiCoding;
import br.com.mind5.geo.geoMapquest.model.checker.GeoquestCheckCoding;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class GeoquestRootCoding extends DeciTreeTemplateWrite<GeoquestInfo> {
	
	public GeoquestRootCoding(DeciTreeOption<GeoquestInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<GeoquestInfo> buildCheckerHook(DeciTreeOption<GeoquestInfo> option) {
		List<ModelChecker<GeoquestInfo>> queue = new ArrayList<>();		
		ModelChecker<GeoquestInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new GeoquestCheckCoding(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<GeoquestInfo>> buildActionsOnPassedHook(DeciTreeOption<GeoquestInfo> option) {
		List<ActionStd<GeoquestInfo>> actions = new ArrayList<>();	
		
		ActionStd<GeoquestInfo> geoCoding = new ActionStdCommom<GeoquestInfo>(option, GeoquestVisiCoding.class);
		
		actions.add(geoCoding);		
		return actions;
	}
}
