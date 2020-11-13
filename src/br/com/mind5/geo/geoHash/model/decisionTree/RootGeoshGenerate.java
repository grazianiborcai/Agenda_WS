package br.com.mind5.geo.geoHash.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.geo.geoHash.model.action.StdGeoshGenerate;
import br.com.mind5.geo.geoHash.model.checker.GeoshCheckGenerate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootGeoshGenerate extends DeciTreeTemplateWrite<GeoshInfo> {
	
	public RootGeoshGenerate(DeciTreeOption<GeoshInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<GeoshInfo> buildCheckerHook(DeciTreeOption<GeoshInfo> option) {		
		List<ModelChecker<GeoshInfo>> queue = new ArrayList<>();		
		ModelChecker<GeoshInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new GeoshCheckGenerate(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<GeoshInfo>> buildActionsOnPassedHook(DeciTreeOption<GeoshInfo> option) {
		List<ActionStd<GeoshInfo>> actions = new ArrayList<>();	
		
		ActionStd<GeoshInfo> generate = new StdGeoshGenerate(option);
		
		actions.add(generate);		
		return actions;
	}
}
