/**
 * Copyright 2016  Jan Petendi <jan.petendi@p-acs.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.petendi.ethereum.android;


import de.petendi.ethereum.android.contract.ContractController;
import de.petendi.ethereum.android.contract.ContractFactory;

public class Contracts {

    private final EthereumAndroid ethereumAndroid;
    Contracts(EthereumAndroid ethereumAndroid) {
        this.ethereumAndroid = ethereumAndroid;

    }

    public <T> T bind(String contractAddress, String abi, Class<T> clazz) {
        return new ContractFactory(new ContractController(ethereumAndroid)).create(contractAddress, abi, clazz);
    }

    public String create(String contractBytecode, String contractAbi, Object... constructorParams) {
        return new ContractController(ethereumAndroid).generateContractCreation(contractBytecode, contractAbi, constructorParams);
    }
}
