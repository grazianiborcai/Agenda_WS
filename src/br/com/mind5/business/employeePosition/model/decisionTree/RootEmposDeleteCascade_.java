package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposDelete;
import br.com.mind5.business.employeePosition.model.action.LazyEmposEnforceLChanged;
import br.com.mind5.business.employeePosition.model.action.LazyEmposMergeUsername;
import br.com.mind5.business.employeePosition.model.action.LazyEmposNodeDeleteEmplate;
import br.com.mind5.business.employeePosition.model.action.LazyEmposNodeDeleteEmpwotm;
import br.com.mind5.business.employeePosition.model.action.LazyEmposUpdate;
import br.com.mind5.business.employeePosition.model.action.StdEmposMergeToDelete;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckDelete;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckExist;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckLangu;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckOwner;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckStorauth;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmposDeleteCascade_ extends DeciTreeWriteTemplate<EmposInfo> {
	
	public RootEmposDeleteCascade_(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildDecisionCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmposCheckDelete(checkerOption);
		queue.add(checker);		
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckOwner(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckStore(checkerOption);
		queue.add(checker);				
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<EmposInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> mergeToDelete = new StdEmposMergeToDelete(option);
		ActionLazy<EmposInfo> enforceLChanged = new LazyEmposEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<EmposInfo> enforceLChangedBy = new LazyEmposMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmposInfo> update = new LazyEmposUpdate(option.conn, option.schemaName);
		ActionLazy<EmposInfo> deleteEmpwotm = new LazyEmposNodeDeleteEmpwotm(option.conn, option.schemaName);
		ActionLazy<EmposInfo> deleteEmplevate = new LazyEmposNodeDeleteEmplate(option.conn, option.schemaName);
		ActionLazy<EmposInfo> deleteEmpos = new LazyEmposDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(deleteEmpwotm);
		update.addPostAction(deleteEmplevate);
		update.addPostAction(deleteEmpos);
		
		actions.add(mergeToDelete);
		return actions;		
	}
}
