package br.com.mind5.business.employeeLeaveDateRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.model.action.StdEmplargMergeToSelect;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckEmp;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckLangu;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckOwner;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckRead;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckStore;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public class RootEmplargSelect extends DeciTreeTemplateRead<EmplargInfo> {
	
	public RootEmplargSelect(DeciTreeOption<EmplargInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmplargInfo> buildCheckerHook(DeciTreeOption<EmplargInfo> option) {
		List<ModelCheckerV1<EmplargInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmplargInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplargCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplargCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplargCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplargCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplargCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmplargInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplargInfo> option) {
		List<ActionStdV1<EmplargInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmplargInfo> select = new StdEmplargMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
