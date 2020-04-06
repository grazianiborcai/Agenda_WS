package br.com.mind5.business.materialMovementSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialMovementSearch.model.action.StdMatmarchMergeToSelect;
import br.com.mind5.business.materialMovementSearch.model.checker.MatmarchCheckLangu;
import br.com.mind5.business.materialMovementSearch.model.checker.MatmarchCheckOwner;
import br.com.mind5.business.materialMovementSearch.model.checker.MatmarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class RootMatmarchSelect extends DeciTreeTemplateRead<MatmarchInfo> {
	
	public RootMatmarchSelect(DeciTreeOption<MatmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatmarchInfo> buildCheckerHook(DeciTreeOption<MatmarchInfo> option) {
		List<ModelCheckerV1<MatmarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatmarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatmarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmarchInfo> option) {
		List<ActionStdV1<MatmarchInfo>> actions = new ArrayList<>();

		ActionStdV1<MatmarchInfo> select = new StdMatmarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
