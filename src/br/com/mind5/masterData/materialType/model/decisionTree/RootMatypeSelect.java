package br.com.mind5.masterData.materialType.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialType.model.action.StdMatypeDaoSelect;
import br.com.mind5.masterData.materialType.model.checker.MatypeCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatypeSelect extends DeciTreeTemplateReadV2<MatypeInfo> {
	
	public RootMatypeSelect(DeciTreeOption<MatypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatypeInfo> buildCheckerHook(DeciTreeOption<MatypeInfo> option) {
		List<ModelCheckerV1<MatypeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatypeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatypeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatypeInfo>> buildActionsOnPassedHook(DeciTreeOption<MatypeInfo> option) {
		List<ActionStdV2<MatypeInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatypeInfo> select = new StdMatypeDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
