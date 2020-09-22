package com.mateusz.workspace;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}
