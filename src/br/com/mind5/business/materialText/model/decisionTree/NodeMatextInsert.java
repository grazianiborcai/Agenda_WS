package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.StdMatextInsert;
import br.com.mind5.business.materialText.model.action.StdMatextUpdate;
import br.com.mind5.business.materialText.model.checker.MatextCheckSoftDelete;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatextInsert extends DeciTreeWriteTemplate<MatextInfo> {
	
	public NodeMatextInsert(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new MatextCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextInfo> insert = new StdMatextInsert(option);
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnFailedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextInfo> update = new StdMatextUpdate(option);
		actions.add(update);
		
		return actions;
	}
}
