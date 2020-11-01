package br.com.mind5.business.materialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.action.StdMatarchObfuscateCodStore;
import br.com.mind5.business.materialSearch.model.action.StdMatarchSuccess;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckSytotin;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeMatarchAuth extends DeciTreeTemplateReadV2<MatarchInfo> {
	
	public NodeMatarchAuth(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatarchInfo> buildCheckerHook(DeciTreeOption<MatarchInfo> option) {
		List<ModelCheckerV1<MatarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatarchCheckSytotin(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatarchInfo> option) {
		List<ActionStdV1<MatarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatarchInfo> success = new StdMatarchSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<MatarchInfo>> buildActionsOnFailedHook(DeciTreeOption<MatarchInfo> option) {
		List<ActionStdV1<MatarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatarchInfo> obfuscateCodStore = new StdMatarchObfuscateCodStore(option);
		
		actions.add(obfuscateCodStore);
		return actions;
	}
}
