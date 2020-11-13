package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.LazyPhoneMergeCountrone;
import br.com.mind5.business.phone.model.action.LazyPhoneMergeFormone;
import br.com.mind5.business.phone.model.action.StdPhoneMergeToSelect;
import br.com.mind5.business.phone.model.checker.PhoneCheckLangu;
import br.com.mind5.business.phone.model.checker.PhoneCheckOwner;
import br.com.mind5.business.phone.model.checker.PhoneCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootPhoneSelect extends DeciTreeTemplateWrite<PhoneInfo> {
	
	public RootPhoneSelect(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildCheckerHook(DeciTreeOption<PhoneInfo> option) {
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhoneCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhoneCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhoneCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> select = new StdPhoneMergeToSelect(option);	
		ActionLazy<PhoneInfo> mergeCountrone = new LazyPhoneMergeCountrone(option.conn, option.schemaName);
		ActionLazy<PhoneInfo> mergeFormone = new LazyPhoneMergeFormone(option.conn, option.schemaName);

		select.addPostAction(mergeCountrone);	
		mergeCountrone.addPostAction(mergeFormone);
		
		actions.add(select);
		
		return actions;
	}
}
