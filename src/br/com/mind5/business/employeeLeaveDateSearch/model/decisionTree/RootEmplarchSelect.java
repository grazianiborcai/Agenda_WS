package br.com.mind5.business.employeeLeaveDateSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.model.action.StdEmplarchMergeToSelect;
import br.com.mind5.business.employeeLeaveDateSearch.model.checker.EmplarchCheckLangu;
import br.com.mind5.business.employeeLeaveDateSearch.model.checker.EmplarchCheckOwner;
import br.com.mind5.business.employeeLeaveDateSearch.model.checker.EmplarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public class RootEmplarchSelect extends DeciTreeTemplateReadV1<EmplarchInfo> {
	
	public RootEmplarchSelect(DeciTreeOption<EmplarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmplarchInfo> buildCheckerHook(DeciTreeOption<EmplarchInfo> option) {
		List<ModelCheckerV1<EmplarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmplarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmplarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplarchInfo> option) {
		List<ActionStdV1<EmplarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmplarchInfo> select = new StdEmplarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
