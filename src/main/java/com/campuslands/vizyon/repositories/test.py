import os

# Directory where your .java files are located
directory = 'C:/Users/braya/Documents/Campus/PushUp/vizyon/vizyon/src/main/java/com/campuslands/vizyon/repositories/entities'

# Iterate over the files in the directory
for filename in os.listdir(directory):
    # Check if the file is a .java file
    if filename.endswith('.java'):
        className = filename.split('.')[0]
        res=f"""package com.campuslands.vizyon.repositories;
        import com.campuslands.vizyon.repositories.entities.{className};
        import org.springframework.data.repository.CrudRepository;
        public interface Repository{className} extends CrudRepository<{className}, Long> """
        res+="{}"
        with open(os.path.join(directory, f"Repository{className}.java"), "w") as file:
            file.write(res)