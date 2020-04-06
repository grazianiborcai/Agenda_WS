package br.com.mind5.business.materialTextDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.model.action.StdMatextaultMergeToSelect;
import br.com.mind5.business.materialTextDefault.model.checker.MatextaultCheckMat;
import br.com.mind5.business.materialTextDefault.model.checker.MatextaultCheckOwner;
import br.com.mind5.business.materialTextDefault.model.checker.MatextaultCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatextaultSelect extends DeciTreeTemplateRead<MatextaultInfo> {
	
	public RootMatextaultSelect(DeciTreeOption<MatextaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatextaultInfo> buildCheckerHook(DeciTreeOption<MatextaultInfo> option) {
		List<ModelCheckerV1<MatextaultInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatextaultInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextaultCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextaultCheckOwner(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextaultCheckMat(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextaultInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextaultInfo> option) {
		List<ActionStdV1<MatextaultInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextaultInfo> select = new StdMatextaultMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
