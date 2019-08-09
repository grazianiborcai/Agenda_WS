package br.com.gda.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.model.action.LazyMatockEnforceBalance;
import br.com.gda.business.materialStock.model.action.LazyMatockNodeInsert;
import br.com.gda.business.materialStock.model.action.StdMatockEnforceLChanged;
import br.com.gda.business.materialStock.model.checker.MatockCheckLangu;
import br.com.gda.business.materialStock.model.checker.MatockCheckMat;
import br.com.gda.business.materialStock.model.checker.MatockCheckMatmovType;
import br.com.gda.business.materialStock.model.checker.MatockCheckOwner;
import br.com.gda.business.materialStock.model.checker.MatockCheckStorauth;
import br.com.gda.business.materialStock.model.checker.MatockCheckStore;
import br.com.gda.business.materialStock.model.checker.MatockCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatockInsert extends DeciTreeWriteTemplate<MatockInfo> {
	
	public RootMatockInsert(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatockInfo> buildDecisionCheckerHook(DeciTreeOption<MatockInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatockInfo>> queue = new ArrayList<>();		
		ModelChecker<MatockInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new MatockCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatockCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatockCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatockCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatockCheckMat(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatockCheckMatmovType(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatockCheckStorauth(checkerOption);
		queue.add(checker);	
		//TODO: verificar categoria material - somente Produto
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatockInfo>> buildActionsOnPassedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStd<MatockInfo>> actions = new ArrayList<>();

		ActionStd<MatockInfo> enforceLChanged = new StdMatockEnforceLChanged(option);
		ActionLazy<MatockInfo> enforceBalance = new LazyMatockEnforceBalance(option.conn, option.schemaName);
		ActionLazy<MatockInfo> insert = new LazyMatockNodeInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceBalance);
		enforceBalance.addPostAction(insert);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
