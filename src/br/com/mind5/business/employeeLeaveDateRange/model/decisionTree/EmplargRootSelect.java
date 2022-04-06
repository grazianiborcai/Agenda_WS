package br.com.mind5.business.employeeLeaveDateRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.model.action.EmplargVisiMergeToSelect;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckEmp;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckLangu;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckOwner;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckRead;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public class EmplargRootSelect extends DeciTreeTemplateRead<EmplargInfo> {
	
	public EmplargRootSelect(DeciTreeOption<EmplargInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplargInfo> buildCheckerHook(DeciTreeOption<EmplargInfo> option) {
		List<ModelChecker<EmplargInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplargInfo> checker;
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplargInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplargInfo> option) {
		List<ActionStd<EmplargInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplargInfo> select = new ActionStdCommom<EmplargInfo>(option, EmplargVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
