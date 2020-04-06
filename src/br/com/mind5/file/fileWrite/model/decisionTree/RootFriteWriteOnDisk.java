package br.com.mind5.file.fileWrite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.file.fileWrite.model.action.StdFriteWriteOnDisk;
import br.com.mind5.file.fileWrite.model.checker.FriteCheckWrite;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootFriteWriteOnDisk extends DeciTreeTemplateWrite<FriteInfo> {
	
	public RootFriteWriteOnDisk(DeciTreeOption<FriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FriteInfo> buildCheckerHook(DeciTreeOption<FriteInfo> option) {
		List<ModelCheckerV1<FriteInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FriteInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FriteCheckWrite(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FriteInfo>> buildActionsOnPassedHook(DeciTreeOption<FriteInfo> option) {
		List<ActionStdV1<FriteInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FriteInfo> writeOnDisk = new StdFriteWriteOnDisk(option);	
		
		actions.add(writeOnDisk);		
		return actions;
	}
}
