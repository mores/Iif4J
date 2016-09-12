/**
 * Copyright (C) 2016  Red Bottle Design, LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.redbottledesign.accounting.quickbooks.models;

/**
 * A representation of an account from the Chart of Accounts in QuickBooks.
 *
 * @author Guy Paddock (guy@redbottledesign.com)
 */
public class Account
extends StringValue {
    /**
     * Constructor for {@link Account} that wraps an account having the
     * specified name.
     *
     * @param   name
     *          The name of the account.
     */
    public Account(final String name) {
        super(name);
    }
}
