package br.com.mind5.geo.geoHash.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.geo.geoHash.model.action.StdGeoshGenerate;
import br.com.mind5.geo.geoHash.model.checker.GeoshCheckGenerate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootGeoshGenerate extends DeciTreeTemplateWriteV2<GeoshInfo> {
	
	public RootGeoshGenerate(DeciTreeOption<GeoshInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<GeoshInfo> buildCheckerHook(DeciTreeOption<GeoshInfo> option) {		
		List<ModelCheckerV1<GeoshInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<GeoshInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new GeoshCheckGenerate(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<GeoshInfo>> buildActionsOnPassedHook(DeciTreeOption<GeoshInfo> option) {
		List<ActionStdV1<GeoshInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<GeoshInfo> generate = new StdGeoshGenerate(option);
		
		actions.add(generate);		
		return actions;
	}
}
