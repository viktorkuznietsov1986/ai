//
//  main.cpp
//  ai.core.test
//
//  Created by Viktor Kuznietsov on 6/29/17.
//  Copyright © 2017 Viktor Kuznietsov. All rights reserved.
//

#include <iostream>
#include <memory>
#include <vector>
#include "../../ai.core/grid.hpp"


int main(int argc, const char * argv[]) {
    // insert code here...
    
    auto g = std::unique_ptr<eight_puzzle::grid>(new eight_puzzle::grid(std::vector<std::vector<int>> {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8}
    }));
    
    std::cout << *g << std::endl;
    
    std::cout << "The grid is in its final state: " << g->is_final_state() << std::endl;
    
    
    g = std::unique_ptr<eight_puzzle::grid>(new eight_puzzle::grid(std::vector<std::vector<int>> {
        {1, 0, 2},
        {3, 4, 5},
        {6, 7, 8}
    }));
    
    std::cout << *g << std::endl;
    
    std::cout << "The grid is in its final state: " << g->is_final_state() << std::endl;
    
    g = std::unique_ptr<eight_puzzle::grid>(new eight_puzzle::grid(std::vector<std::vector<int>> {
        {0, 4, 2},
        {3, 1, 5},
        {6, 7, 8}
    }));
    
    std::cout << *g << std::endl;
    
    std::cout << "The grid is in its final state: " << g->is_final_state() << std::endl;
    
    
    
    return 0;
}
