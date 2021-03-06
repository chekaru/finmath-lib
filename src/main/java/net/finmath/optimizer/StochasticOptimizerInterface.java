/*
 * (c) Copyright Christian P. Fries, Germany. All rights reserved. Contact: email@christianfries.com.
 *
 * Created on 29.05.2015
 */

package net.finmath.optimizer;

import net.finmath.stochastic.RandomVariableInterface;

/**
 * @author Christian Fries
 *
 */
public interface StochasticOptimizerInterface {

	public interface ObjectiveFunction {
		public void setValues(RandomVariableInterface[] parameters, RandomVariableInterface[] values) throws SolverException;
	}

	/**
	 * Get the best fit parameter vector.
	 * 
	 * @return The best fit parameter.
	 */
	RandomVariableInterface[] getBestFitParameters();

	/**
	 * @return the the root mean square error achieved with the the best fit parameter
	 */
	double getRootMeanSquaredError();

	/**
	 * Get the number of iterations.
	 * 
	 * @return The number of iterations required
	 */
	int getIterations();

	/**
	 * Runs the optimization.
	 * 
	 * @throws SolverException Thrown if the valuation fails, specific cause may be available via the <code>cause()</code> method.
	 */
	void run() throws SolverException;
}