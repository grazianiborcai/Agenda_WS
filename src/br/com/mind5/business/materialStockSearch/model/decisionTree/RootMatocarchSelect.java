package br.com.mind5.business.materialStockSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.business.materialStockSearch.model.action.StdMatocarchMergeToSelect;
import br.com.mind5.business.materialStockSearch.model.checker.MatocarchCheckLangu;
import br.com.mind5.business.materialStockSearch.model.checker.MatocarchCheckOwner;
import br.com.mind5.business.materialStockSearch.model.checker.MatocarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class RootMatocarchSelect extends DeciTreeTemplateRead<MatocarchInfo> {
	
	public RootMatocarchSelect(DeciTreeOption<MatocarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatocarchInfo> buildCheckerHook(DeciTreeOption<MatocarchInfo> option) {
		List<ModelCheckerV1<MatocarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatocarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatocarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatocarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatocarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatocarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatocarchInfo> option) {
		List<ActionStdV1<MatocarchInfo>> actions = new ArrayList<>();

		ActionStdV1<MatocarchInfo> select = new StdMatocarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
