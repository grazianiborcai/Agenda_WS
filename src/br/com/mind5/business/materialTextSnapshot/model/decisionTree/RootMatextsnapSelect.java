package br.com.mind5.business.materialTextSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.model.action.StdMatextsnapMergeToSelect;
import br.com.mind5.business.materialTextSnapshot.model.checker.MatextsnapCheckMat;
import br.com.mind5.business.materialTextSnapshot.model.checker.MatextsnapCheckOwner;
import br.com.mind5.business.materialTextSnapshot.model.checker.MatextsnapCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatextsnapSelect extends DeciTreeTemplateRead<MatextsnapInfo> {
	
	public RootMatextsnapSelect(DeciTreeOption<MatextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatextsnapInfo> buildCheckerHook(DeciTreeOption<MatextsnapInfo> option) {
		List<ModelCheckerV1<MatextsnapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatextsnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextsnapCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextsnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextsnapCheckMat(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextsnapInfo> option) {
		List<ActionStdV1<MatextsnapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextsnapInfo> select = new StdMatextsnapMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
