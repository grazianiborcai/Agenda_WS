package br.com.gda.legacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.helper.StoreEmployee;
import br.com.gda.legacy.dao.helper.StoreEmployeeHelper;
import br.com.gda.legacy.db.ConnectionBD;
import br.com.gda.legacy.db.GdaDB;
import br.com.gda.helper.RecordMode;

public class StoreEmployeeDAO extends ConnectionBD {

	public void insertStoreEmployee(List<StoreEmployee> storeEmployees) throws SQLException {
		Connection conn = null;
		PreparedStatement insertStmtT01 = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);

			insertStmtT01 = conn
					.prepareStatement(StoreEmployeeHelper.ST_IN_ALL);

			for (StoreEmployee storeEmployee : storeEmployees) {
				prepareInsert(insertStmtT01, storeEmployee);			
			}

			insertStmtT01.executeBatch();
			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn, insertStmtT01);
		}

	}

	public void updateStoreEmployee(List<StoreEmployee> storeList) throws SQLException {
		Connection conn = null;
		PreparedStatement insertStmtT01 = null;
		PreparedStatement updateStmtT01 = null;
		PreparedStatement deleteStmtT01 = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);

			insertStmtT01 = conn.prepareStatement(StoreEmployeeHelper.ST_IN_ALL);
			updateStmtT01 = conn.prepareStatement(StoreEmployeeHelper.ST_UP_ALL_BY_FULL_KEY);

			StoreEmployeeHelper storeEmployeeHelper = new StoreEmployeeHelper();
			for (StoreEmployee storeEmployee : storeList) {

				if (storeEmployee.getRecordMode() != null
						&& storeEmployee.getRecordMode().equals(
								RecordMode.ISNEW)) {

					prepareInsert(insertStmtT01, storeEmployee);

				} else {
					if (storeEmployee.getRecordMode() != null
							&& (storeEmployee.getRecordMode().equals(
									RecordMode.ISDELETED) || storeEmployee
									.getRecordMode().equals(
											RecordMode.RECORD_DELETED))) {

						deleteStmtT01 = conn
								.prepareStatement(storeEmployeeHelper
										.prepareDelete(GdaDB.EQ,
												storeEmployee.getCodOwner(),
												GdaDB.EQ,
												storeEmployee.getCodStore(),
												GdaDB.EQ,
												storeEmployee.getCodEmployee()));

						deleteStmtT01.execute();

					} else {

						updateStmtT01.setInt(
								1,
								storeEmployee.getCodPositionStore() != null
										&& !storeEmployee.getCodPositionStore()
												.equals(0) ? storeEmployee
										.getCodPositionStore() : storeEmployee
										.getCodPosition());
						updateStmtT01.setString(2, RecordMode.RECORD_OK);
						updateStmtT01.setLong(3, storeEmployee.getCodOwner());
						updateStmtT01.setInt(4, storeEmployee.getCodStore());
						updateStmtT01.setInt(5, storeEmployee.getCodEmployee());

						updateStmtT01.addBatch();
					}
				}
			}

			insertStmtT01.executeBatch();
			updateStmtT01.executeBatch();
			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn, deleteStmtT01, insertStmtT01, updateStmtT01);
		}
	}

	public void deleteStoreEmployee(long codOwner, int codStore, int codEmployee) throws SQLException {
		Connection conn = null;
		PreparedStatement deleteStmt = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			deleteStmt = conn.prepareStatement(StoreEmployeeHelper.ST_FLAG_AS_DELETED);			
			deleteStmt.setString(1, RecordMode.RECORD_DELETED);
			deleteStmt.setLong(2, codOwner);
			deleteStmt.setInt(3, codStore);
			deleteStmt.setInt(4, codEmployee);

			deleteStmt.execute();
			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn, deleteStmt);
		}
	}

	public ArrayList<StoreEmployee> selectStoreEmployee(List<Long> codOwner,
			List<Integer> codStore, List<Integer> codEmployee,
			List<String> cpf, List<String> password, List<String> name,
			List<Byte> codPosition, List<Byte> codGender,
			List<String> bornDate, List<String> email, List<String> address1,
			List<String> address2, List<Integer> postalcode, List<String> city,
			List<String> country, List<String> state, List<String> phone,
			List<String> recordMode) throws SQLException {

		ArrayList<StoreEmployee> employeeList = new ArrayList<StoreEmployee>();
		Connection conn = null;
		PreparedStatement selectStmt = null;
		ResultSet resultSet = null;

		try {

			conn = getConnection();

			StoreEmployeeHelper storeEmployeeHelper = new StoreEmployeeHelper();

			selectStmt = conn.prepareStatement(storeEmployeeHelper
					.prepareSelect(codOwner, codStore, codEmployee, cpf,
							password, name, codPosition, codGender, bornDate,
							email, address1, address2, postalcode, city,
							country, state, phone, recordMode));

			resultSet = selectStmt.executeQuery();

			while (resultSet.next()) {

				employeeList.add(storeEmployeeHelper.assignResult(resultSet));
			}

			return employeeList;

		} catch (SQLException e) {
			throw e;
		} finally {
			closeConnection(conn, selectStmt, resultSet);
		}
	}

	private void prepareInsert(PreparedStatement insertStmtT01,
			StoreEmployee storeEmployee) throws SQLException {

		insertStmtT01.setLong(1, storeEmployee.getCodOwner());
		insertStmtT01.setInt(2, storeEmployee.getCodStore());
		insertStmtT01.setInt(3, storeEmployee.getCodEmployee());
		insertStmtT01
				.setInt(4,
						storeEmployee.getCodPositionStore() != null
								&& !storeEmployee.getCodPositionStore().equals(
										0) ? storeEmployee
								.getCodPositionStore() : storeEmployee
								.getCodPosition());
		insertStmtT01.setString(5, RecordMode.RECORD_OK);

		insertStmtT01.addBatch();
	}

}
